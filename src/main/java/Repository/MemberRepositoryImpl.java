package Repository;

import Domain.Member;
import Exception.DuplicateIdException;
import Exception.NotFoundMemberException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : 조재철
 * @since 1.0
 */
public class MemberRepositoryImpl implements MemberRepository {

    Map<Integer, Member> memberMap = new HashMap<>();

    private static MemberRepositoryImpl instance = new MemberRepositoryImpl();

    private MemberRepositoryImpl() {
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    @Override
    public void registerMember(String username) {
        if (memberMap.containsValue(username)) {
            throw new DuplicateIdException("이미 존재하는 아이디 입니다.");
        }

        memberMap.put(memberMap.size(), new Member(memberMap.size(), username));
    }

    @Override
    public void deleteMember(Integer id) {
        if (!memberMap.containsKey(id)) {
            throw new NotFoundMemberException("해당 멤버가 존재하지 않습니다.");
        }

        memberMap.remove(id);
    }

    @Override
    public void updateMember(Integer id, String username) {
        if (!memberMap.containsKey(id)) {
            throw new NotFoundMemberException("해당 멤버가 존재하지 않습니다.");
        }

        if (memberMap.containsValue(username)) {
            throw new DuplicateIdException("이미 존재하는 아이디 입니다.");
        }

        memberMap.put(id, new Member(id, username));
    }

    @Override
    public Map<Integer, Member> findMemberMap() {
        return this.memberMap;
    }
}
