package Repository;

import Domain.Member;
import java.util.Map;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface MemberRepository {

    static MemberRepository getInstance() {
        return MemberRepositoryRealImpl.getInstance(); // --> Mysql에 저장

        //return MemberRepositoryImpl.getInstance() --> Java 자체 Map으로 저장
    }

    void registerMember(String username);

    void deleteMember(Integer id);

    void updateMember(Integer id, String username);

    Map<Integer, Member> findMemberMap();
}
