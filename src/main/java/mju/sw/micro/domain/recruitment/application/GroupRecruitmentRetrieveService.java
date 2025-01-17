package mju.sw.micro.domain.recruitment.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import lombok.RequiredArgsConstructor;
import mju.sw.micro.domain.group.dao.StudentGroupRepository;
import mju.sw.micro.domain.group.domain.StudentGroup;
import mju.sw.micro.domain.recruitment.dao.GroupRecruitmentRepository;
import mju.sw.micro.domain.recruitment.dao.RecruitmentImageRepository;
import mju.sw.micro.domain.recruitment.domain.GroupRecruitment;
import mju.sw.micro.domain.recruitment.domain.RecruitmentImage;
import mju.sw.micro.domain.recruitment.dto.response.DetailGroupRecruitmentResponse;
import mju.sw.micro.domain.recruitment.dto.response.SimpleGroupRecruitmentResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupRecruitmentRetrieveService {

	private final GroupRecruitmentRepository recruitmentRepository;
	private final StudentGroupRepository groupRepository;

	private final RecruitmentImageRepository recruitmentImageRepository;

	public List<SimpleGroupRecruitmentResponse> retrieveAllRecruitments() {
		List<GroupRecruitment> recruitmentList = recruitmentRepository.findAllByOrderByCreatedDateTimeDesc();
		List<SimpleGroupRecruitmentResponse> response = new ArrayList<>();

		for (GroupRecruitment recruitment : recruitmentList) {
			Optional<StudentGroup> optionalStudentGroup = groupRepository.findById(recruitment.getGroup().getId());
			response.add(SimpleGroupRecruitmentResponse.of(recruitment, optionalStudentGroup.get()));
		}
		return response;
	}

	public DetailGroupRecruitmentResponse retrieveRecruitment(Long recruitmentId) {
		GroupRecruitment recruitment = recruitmentRepository.findById(recruitmentId)
			.orElseThrow(() -> new NotFoundException("Recruitment not found with id: " + recruitmentId));
		return DetailGroupRecruitmentResponse.of(recruitment);
	}

	public List<RecruitmentImage> getRecruitmentImages() {
		return recruitmentImageRepository.findAll();
	}

	public List<GroupRecruitment> getAllRecruitment() {
		return recruitmentRepository.findAll();
	}
}
