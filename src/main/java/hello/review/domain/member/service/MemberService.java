package hello.review.domain.member.service;

import hello.review.domain.member.entity.Member;
import hello.review.exception.BusinessLogicException;
import hello.review.exception.ExceptionCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member) {
        //TODO Member 객체를 DB에 Member 객체 저장 후 저장한 Member 객체 return
        Member createdMember = member;
        return createdMember;
    }

    public Member updateMember(Member member) {
        //TODO Member 객체를 DB에 업데이트 후 업데이트 한 Member 객체 return
        Member updatedMember = member;
        return updatedMember;
    }

    public Member findMember(long memberId) {
        //TODO 해당 ID를 가진 Member 객체 DB에서 조회 후에 Member 객체 return
//        return new Member(memberId, "alsry922@gmail.com", "정민교", "010-1111-1111");
        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }
    public List<Member> findMembers() {
        //TODO DB에서 모든 Member 객체 조회 후 return
        List<Member> members = List.of(new Member(1, "alsry922@gmail.com", "정민교", "010-1111-1111"),
                new Member(2, "hgd@gmail.com", "홍길동", "010-1234-5678"));

        return members;
    }

    public void deleteMember(long memberId) {
        //TODO 해당 ID를 가진 Member 객체 DB에서 삭제
        throw new NullPointerException();
    }

}
