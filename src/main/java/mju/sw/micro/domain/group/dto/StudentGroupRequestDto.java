package mju.sw.micro.domain.group.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import mju.sw.micro.domain.group.domain.Campus;

import java.util.List;

@Getter
public class StudentGroupRequestDto {
	@NotBlank
	private String groupName;
	private String logoImageUrl;
	private int establishedYear;
	private String numOfMember;
	@NotBlank
	private String introduction;
	private List<String> relationMajor;
	private List<String> relatedTag;
	private List<String> activityTitle;
	private List<String> activityContent;
	@NotBlank
	private String campus;
	@NotBlank
	private String largeCategory;
	@NotBlank
	private String mediumCategory;
	@NotBlank
	private String smallCategory;
	@NotBlank
	private String subCategory;
}
