package Repository;

import Domain.Member;
import config.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : 조재철
 * @since 1.0
 */
public class MemberRepositoryRealImpl implements MemberRepository {

    private static MemberRepositoryRealImpl instance = new MemberRepositoryRealImpl();

    private MemberRepositoryRealImpl() {
    }

    public static MemberRepository getInstance() {
        Connector.connection();
        return instance;
    }

    @Override
    public void registerMember(String username) {
        try {
            String sql = "INSERT INTO member (username) VALUES (?)";

            PreparedStatement statement = Connector.conn.prepareStatement(sql);
            statement.setString(1, username);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteMember(Integer id) {
        try {
            String sql = "DELETE FROM member WHERE id = ?";

            PreparedStatement statement = Connector.conn.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMember(Integer id, String username) {
        try {
            String sql = "UPDATE member SET username = ? WHERE id = ?";

            PreparedStatement statement = Connector.conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Integer, Member> findMemberMap() {
        Map<Integer, Member> map = new HashMap<>();

        try {
            String sql = "SELECT * FROM member";

            Statement statement = Connector.conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Integer id = result.getInt("id");
                String username = result.getString("username");

                map.put(id, new Member(id, username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }
}
