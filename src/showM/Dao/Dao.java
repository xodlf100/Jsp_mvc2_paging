package showM.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import showM.Dto.BoardDto;
import showM.Dto.Dto;
import showM.Dto.JoinDto;

public class Dao {

	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;

	String url = "jdbc:mariadb://183.111.199.155:3306/xodlf100";
	String id = "xodlf100";
	String pw = "roshadk12";
	
	//디비연결
	public void getCon() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 판매 상품 전체 데이터 가져오기
	public List<Dto> select() {
		List<Dto> dto = new ArrayList<>();
		getCon();

		String sql = "select * from showm_mvc2";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dto dtoo = new Dto();
				dtoo.setIdx(rs.getInt(1));
				dtoo.setPicture(rs.getString(2));
				dtoo.setTitle(rs.getString(3));
				dtoo.setContents(rs.getString(4));
				dtoo.setPrice(rs.getString(5));

				dto.add(dtoo);
			}
			con.close();
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
		
	}

	// 회원 가입
	public void join(JoinDto joinDto) {
		try {
			getCon();
			String sql = "insert into showm_mvc2_join values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, joinDto.getId());
			pstmt.setString(2, joinDto.getPassword());
			pstmt.setString(3, joinDto.getName());
			pstmt.setString(4, joinDto.getEmail());
			pstmt.executeUpdate();
			con.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원리스트 전체  데이터 가져오기
	public List<JoinDto> check() {
		List<JoinDto> jo = new ArrayList<>();
		getCon();
		try {
			String sql = "select * from showm_mvc2_join";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				JoinDto j = new JoinDto();
				j.setId(rs.getString(1));
				j.setPassword(rs.getString(2));
				j.setName(rs.getString(3));
				j.setEmail(rs.getString(4));
				jo.add(j);
			}
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jo;
	}
	
	// 로그인
	public int login(String id, String password) {
		int result = 0;
		getCon(); //드라이버연결
		try {
			//쿼리문작성
			String SQL = "select count(*) from showm_mvc2_join where id = ? and password = ?";
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			//여러개 -while //한개 - if
			if(rs.next()) {
				result = rs.getInt(1);
			}
			con.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//id를 통해 회원 전체 데이터 불러오기
	public JoinDto getMember(String id) {
		getCon();
		JoinDto dto = null; //객체 레퍼런스 생성
		//왜 null인가? 정보가 생성되는 시점은 rs에 있을때이다.
		//따라서 rs가 없을땐 굳이 만들필요가 없다.
		try {
			String sql = "select * from showm_mvc2_join where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new JoinDto();
				dto.setId(rs.getString(1));
				dto.setPassword(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setEmail(rs.getString(4));
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
	
	// 회원 정보 업데이트
	public void myUpdate(JoinDto dto) {
		try {
			getCon();
			String sql = "update showm_mvc2_join set password = ?, name = ?, email = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getId());
			pstmt.executeUpdate(); // 정보를 전송만 하면 되므로 rs 그릇이 필요 없다.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원 탈퇴 Delete
	public void Withdrawal(String id) {
		try {
			getCon();
			String sql = "delete from showm_mvc2_join where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//제품 상세페이지에 5개씩 랜덤 뿌리기
	public List<Dto> LimitSel(){
		List<Dto> dto = new ArrayList<>();
		try {
			getCon();
			String sql = "SELECT * FROM showm_mvc2 ORDER BY RAND() LIMIT 5";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Dto dtoo = new Dto();
				dtoo.setIdx(rs.getInt(1));
				dtoo.setPicture(rs.getString(2));
				dtoo.setTitle(rs.getString(3));
				dtoo.setContents(rs.getString(4));
				dtoo.setPrice(rs.getString(5));
				dto.add(dtoo);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 제품 가져오기
	public Dto getProduct(String idx) {
		Dto dto = new Dto();
		try {
			getCon();
			String sql = "select * from showm_mvc2 where idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setIdx(rs.getInt(1));
				dto.setPicture(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContents(rs.getString(4));
				dto.setPrice(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
	
	// 키워드 받아 상품 검색
	public List<Dto> search(String keyword){
		List<Dto> dto = new ArrayList<>();
		try {
			getCon();
			String sql = "select * from showm_mvc2 WHERE title like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Dto dtoo = new Dto();
				dtoo.setIdx(rs.getInt(1));
				dtoo.setPicture(rs.getString(2));
				dtoo.setTitle(rs.getString(3));
				dtoo.setContents(rs.getString(4));
				dtoo.setPrice(rs.getString(5));
				dto.add(dtoo);
			}
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
	
	// 게시판 글쓰기
	public void write(BoardDto dto) {
		try {
			getCon();
			String sql = "insert into showm_mvc2_board (title, joinName, content) values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getJoinName());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate();
		
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 게시판 데이터 전체 불러오기
	public List<BoardDto> boardSelectAll(){
		List<BoardDto> dto = new ArrayList<>();
		try {
			getCon();
			String sql = "select * from showm_mvc2_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto dtoo = new BoardDto();
				dtoo.setIdx(rs.getInt(1));
				dtoo.setTitle(rs.getString(2));
				dtoo.setJoinName(rs.getString(3));
				dtoo.setRegdate(rs.getString(4));
				dto.add(dtoo);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 게시판 클릭해서 상세 내용 보기
	public BoardDto contentDetail(String idx){
		BoardDto dto = new BoardDto();
		try {
			getCon();
			String sql = "select * from showm_mvc2_board where idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setIdx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setJoinName(rs.getString(3));
				dto.setRegdate(rs.getString(4));
				dto.setContent(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 게시판 수정
	public void contentUpdate(BoardDto dto, String idx) {
		try {
			getCon();
			String sql = "update showm_mvc2_board set title = ?, regdate = now(), content = ? where idx = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, idx);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 삭제
	public void contentDetailDelete(String idx) {
		try {
			getCon();
			String sql = "delete from showm_mvc2_board where idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idx);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원 정보에서 id만 가져오기
	public List<JoinDto> idAll() {
		List<JoinDto> dto = new ArrayList<>();
		try {
			getCon();
			String sql = "select id from showm_mvc2_join";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JoinDto dtoo = new JoinDto();
				dtoo.setId(rs.getString(1));
				dto.add(dtoo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
	
	public static void main(String[] args) {
		Dao dao = new Dao();
		dao.getCon();
	}
}
