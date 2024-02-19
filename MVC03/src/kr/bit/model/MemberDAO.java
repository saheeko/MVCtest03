package kr.bit.model;
//JDBC-myBatis.JPA
import java.sql.*;
import java.util.ArrayList;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//데이터베이스 연결객체를 생성한다.(Connection)
	public void getConnect() {
		//데이터베이스접속url
		String URL="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user="root";
		String password="admin12345";
		//mysql driver loading
		try {
			//동적로딩(실행시점에서 객체를 생성하는 방법)
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	//회원저장 동작
	public int memberInsert(MemberVO vo) {
			String SQL="insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
			getConnect();
			//sql문장을 전송하는 객체를 생성한다 conn이 db에 연결되잇어서 사용
			int cnt=-1;
			try {
				ps=conn.prepareStatement(SQL);// 미리컴파일(속도가 빠르다)
				ps.setString(1, vo.getId());
				ps.setString(2, vo.getPass());
				ps.setString(3, vo.getName());
				ps.setInt(4, vo.getAge());
				ps.setString(5, vo.getEmail());
				ps.setString(6, vo.getPhone());
				
				cnt=ps.executeUpdate();//디비에 실제 전송하여 실행. int cnt를 추가는 성공하면 1 실패하면 0 으로 나타내기위해
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//에러 유무의 상관없이 사용됨.
			finally {
				dbClose();
				//데이터 베이스 연결끊기에 만들어놓은 객체 이름 
			}
			return cnt; //1 or 0		
	}
	//회원(VO)전체 리스트(ArrayList) 가져오기
	public ArrayList<MemberVO> memberList() {
		String SQL="select * from member"; //전체리스트
		getConnect(); // connect연결 다시해주기 - 객체를 다시 만들었기 때문에.
		//arraylist로 담기위해 쓴 코드
		ArrayList<MemberVO> list=new ArrayList<MemberVO> ();
		try {
			ps=conn.prepareStatement(SQL);
			rs=ps.executeQuery(); //rs-결과의 집합을 가진 커서
			while(rs.next()) {
				int num=rs.getInt("num");
				String id=rs.getString("id");
				String pass=rs.getString("pass");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				//vo로 데이터 묶고 
				MemberVO vo=new MemberVO(num, id, pass, name, age, email, phone);
				//arraylist로 담기
				list.add(vo);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
			//데이터 베이스 연결끊기에 만들어놓은 객체 이름 
		}
		return list;
		//list를 return하기 위해서 public void가아니라  arraylist의 회원이 담아져있는 타입으로
		//변경해야한다. -public ArrayList<MemberVO>
		
	}//memberList
	
	//회원삭제메소드 (int num)은 넘버를 읽어와서 그넘버에 해당하는 회원 삭제하기위해.
	public int memberDelete(int num) {
		String SQL="delete from member where num=?";
		getConnect();
		int cnt=-1;
		try {
			ps=conn.prepareStatement(SQL); //sql를 전송할수있는 객체 ps
			ps.setInt(1, num);
			cnt=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//memberDelete
	
	//회원상세 보기.
	public MemberVO memberContent(int num) {
		String SQL="select * from member where num=?";
		getConnect();
		//vo를 묶는것이 try안에 있어서 지역변수 이기에 따로 뺴서 해준다 미리.
		MemberVO vo=null;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs=ps.executeQuery();
			if(rs.next()) {
				//회원한명의 정보를 가져와서 vo로 묶는다.
				num=rs.getInt("num");
				String id=rs.getString("id");
				String pass=rs.getString("pass");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				vo=new MemberVO(num, id, pass, name, age, email, phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return vo;
	}
	//회원 수정 업데이트
	public int memberUpdate(MemberVO vo) {
		String SQL="update member set age=?, email=?, phone=? where num=?";
		getConnect();
		int cnt=-1;
		try {
			ps=conn.prepareStatement(SQL );
			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());
			
			cnt=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return cnt;
	}
	
	
	
	//데이터베이스 연결 끊기
	public void dbClose() {
		try {
			//rs,ps,conn이 만들어져 있을 경우 끊어주고 다시 생성한부분만 연결되게하라.
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
