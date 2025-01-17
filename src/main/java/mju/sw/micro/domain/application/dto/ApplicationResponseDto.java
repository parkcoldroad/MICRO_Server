package mju.sw.micro.domain.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mju.sw.micro.domain.application.domain.Application;

import java.util.List;

@Getter
@Setter
@Data
public class ApplicationResponseDto {
	private Long id;
	private Long userId;
	private Long recruitmentId;
	private List<String> answers;
	private Boolean passStatus;
	private String grade;
	private String supportField;
	private Boolean isAttending;
	private Boolean isSubmit;

	public static ApplicationResponseDto fromApplication(Application application) {
		ApplicationResponseDto dto = new ApplicationResponseDto();
		dto.setId(application.getId());
		dto.setRecruitmentId(application.getRecruitmentId());
		dto.setUserId(application.getUserId());
		dto.setAnswers(application.getAnswers());
		dto.setPassStatus(application.getPassStatus());
		dto.setGrade(application.getGrade());
		dto.setSupportField(application.getSupportField());
		dto.setIsAttending(application.getIsAttending());
		dto.setIsSubmit(application.getIsSubmit());
		return dto;
	}
}
