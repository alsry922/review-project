package hello.review.domain.member.mapper;

import hello.review.domain.member.dto.MemberPatchDto;
import hello.review.domain.member.dto.MemberPostDto;
import hello.review.domain.member.dto.MemberResponseDto;
import hello.review.domain.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    public Member memberPostDtoToMember(MemberPostDto memberPostDto);

    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

    public MemberResponseDto memberToMemberResponseDto(Member member);
}
