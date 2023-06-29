package mju.sw.micro.domain.sample.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import mju.sw.micro.domain.sample.dao.SampleRepository;
import mju.sw.micro.domain.sample.domain.Sample;
import mju.sw.micro.domain.sample.dto.request.SampleCreateServiceRequest;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleService {

	private final SampleRepository sampleRepository;

	@Transactional
	public Sample createSample(SampleCreateServiceRequest request) {
		Sample sample = request.toEntity();
		return sampleRepository.save(sample);
	}

}