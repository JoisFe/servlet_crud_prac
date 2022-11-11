package Service;

import Domain.Member;
import java.util.Map;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface MemberService {

    static MemberService getInstance() {
        return MemberServiceImpl.getInstance();
    }

    void registerMember(String username);
    void deleteMember(Integer id);
    void updateMember(Integer id, String username);
    Map<Integer, Member> findMemberMap();
}
