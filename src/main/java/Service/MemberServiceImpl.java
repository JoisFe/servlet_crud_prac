package Service;

import Domain.Member;
import Repository.MemberRepository;
import java.util.Map;

/**
 * @author : 조재철
 * @since 1.0
 */
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    private static MemberServiceImpl instance = new MemberServiceImpl();

    private MemberServiceImpl() {}

    public static MemberService getInstance() {
        return instance;
    }

    @Override
    public void registerMember(String username) {
        memberRepository.registerMember(username);
    }

    @Override
    public void deleteMember(Integer id) {
        memberRepository.deleteMember(id);
    }

    @Override
    public void updateMember(Integer id, String username) {
        memberRepository.updateMember(id, username);
    }

    @Override
    public Map<Integer, Member> findMemberMap() {
        return memberRepository.findMemberMap();
    }
}
