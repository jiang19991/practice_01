package Test.book;

public class BookModel {

    private int id;
    private int count;//借阅次数
    private String cardId;
    
    public BookModel(int id, int count) {
        this.id = id;
        this.count = count;
    }

	public BookModel(int id, String cardId) {
		super();
		this.id = id;
		this.cardId = cardId;
	}



	public BookModel(int id) {
		super();
		this.id = id;
	}


/**
 * 重写equals和hashcode方法，只要书的id一样，就认为是同一本书
 * 用于记录书的累计借阅记录
 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookModel other = (BookModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
