package hello.review.domain.member.controller;

import hello.review.domain.member.dto.MemberPatchDto;
import hello.review.domain.member.dto.MemberPostDto;
import hello.review.domain.member.dto.MemberResponseDto;
import hello.review.domain.member.entity.Member;
import hello.review.domain.member.mapper.MemberMapper;
import hello.review.domain.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/members")
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = mapper.memberPostDtoToMember(memberPostDto);

        Member response = memberService.createMember(member);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@Valid @RequestBody MemberPatchDto memberPatchDto,
                                      @PathVariable("member-id") @Positive long memberId) {
        memberPatchDto.setMemberId(memberId);
        Member member = mapper.memberPatchDtoToMember(memberPatchDto);

        Member response = memberService.updateMember(member);
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member response = memberService.findMember(memberId);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();

        List<MemberResponseDto> response = members.stream()
                .map(mapper::memberToMemberResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
