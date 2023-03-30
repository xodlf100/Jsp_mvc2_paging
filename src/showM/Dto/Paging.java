package showM.Dto;

public class Paging {
	private int startNum; // 아래 시작 페이지 번호
	private int endNum; // 아래 끝 페이지 번호
	private int disPageNum; // 아래 몇개씩 뿌릴건지
	private int perPageNum; // 게시글 몇개 뿌릴 건지
	private int totalCount; // 총 게시글
	private int startValue; // 쿼리문에서 LIMIT 처음꺼
	private int currentPage; // 현재 보는 페이지
	private int realPage; // 마지막 페이지로 만들어주기
	private boolean prev; // 이전 버튼
	private boolean next; // 다음 버튼
	
	public Paging() {
		this.disPageNum = 10;
		this.perPageNum = 10;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getDisPageNum() {
		return disPageNum;
	}

	public void setDisPageNum(int disPageNum) {
		this.disPageNum = disPageNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartValue() {
		return startValue;
	}

	public void setStartValue(int startValue) {
		this.startValue = startValue;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRealPage() {
		return realPage;
	}

	public void setRealPage(int realPage) {
		this.realPage = realPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	
	
	
	
}
