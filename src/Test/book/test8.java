package Test.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 姜柏宇 题目8
 */
public class test8 {

	HashMap<BookModel, Integer> bookMap = new HashMap<>();// 记录所有书及借阅次数
	Map<BookModel, Integer> bookStockeMap = new HashMap<BookModel, Integer>();//记录库存容量
	ArrayList<BookModel> bookList = new ArrayList<>();// 记录所有的书的信息
	ArrayList<CardModel> cardList = new ArrayList<>();// 记录所有借阅卡的信息
	HashMap<CardModel, HashMap<BookBorrowModel, Integer>> cardHashMap = new HashMap<>();//按借阅卡统计借书记录
	HashMap<BookBorrowModel, Integer> temp = new HashMap<BookBorrowModel, Integer>();

	public static void main(String[] args) {

		test8 t = new test8();
		t.print();
		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("请键入操作码：");
			String s4 = scanner.nextLine();
			int n = Integer.valueOf(s4);
			if (n == 0) {
				System.out.println("感谢您的使用，再见！");
				break;
			}
			while (n != 0) {

				if (n == 1) {
					System.out.println("请输入进书的数量：");
					String s3 = scanner.nextLine();
					int num = Integer.valueOf(s3);
					for (int i = 0; i < num; i++) {
						System.out.println("书号：");
						String s1 = scanner.nextLine();
						int id = Integer.valueOf(s1);
						System.out.println("数量：");
						String s2 = scanner.nextLine();
						int count = Integer.valueOf(s2);
						t.ProduceBook(id, count);
					}
					System.out.println("当前拥有的书分别是：");

					for(BookModel i : t.bookStockeMap.keySet()) {
						System.out.println(i.getId() + "号书:" + t.bookStockeMap.get(i)+"本");
					}
					break;
				} else if (n == 2) {
					System.out.println("请输入办理的借阅卡的id:");
					String cardId = scanner.nextLine();

					t.HandleCard(cardId);

					break;
				} else if (n == 3) {
					System.out.println("请输入您的借阅卡id:");
					String borrowCardId = scanner.nextLine();
					CardModel card = new CardModel(borrowCardId);
					if (!t.cardList.contains(card)) {
						System.out.println("对不起，请先办理借阅卡！");
						break;
					}

					System.out.println("当前库存情况：");
					for(BookModel i : t.bookStockeMap.keySet()) {
						System.out.println(i.getId() + "号书:" + t.bookStockeMap.get(i)+"本");
					}

					System.out.println("请输入所借书的id:");
					String s7 = scanner.nextLine();
					int borrowBookId = Integer.valueOf(s7);
					BookModel book = new BookModel(borrowBookId);
					if (!t.bookList.contains(book)) {
						System.out.println("抱歉，我们暂时没有这本书");
					} else {
						t.BorrowBook(borrowBookId, borrowCardId);
						
						System.out.println("当前总的借书情况：");
						for (BookModel key : t.bookMap.keySet()) {
							System.out.println("书号：" + key.getId() + "  借出数量：" + t.bookMap.get(key));
						}
					}

					break;
				} else if (n == 4) {
					System.out.println("您好，还书请先输入您的借阅卡id:");
					String borrowCardId = scanner.nextLine();
					CardModel card = new CardModel(borrowCardId);
					if (!t.cardList.contains(card)) {
						System.out.println("对不起，您输入的卡号不正确！");
						break;
					}
					System.out.println("请输入您所还书的id:");
					String s9 = scanner.nextLine();
					int borrowBookId = Integer.valueOf(s9);
					BookModel book = new BookModel(borrowBookId);
					if (!t.bookList.contains(book)) {
						System.out.println("输入错误，请检查书号后重新输入！");
					} else {
						t.ReturnBook(borrowBookId, borrowCardId);
						System.out.println("还书成功!");
						System.out.println("当前总的借书书情况：");
						for (BookModel key : t.bookMap.keySet()) {
							System.out.println("书号：" + key.getId() + "  借出数量：" + t.bookMap.get(key));
						}
					}
					break;
				} else if (n == 5) {
					System.out.println("请输入需要查询的书的id：");
					String s10 = scanner.nextLine();
					int bookID = Integer.valueOf(s10);
					BookModel book = new BookModel(bookID);
					if (!t.bookMap.containsKey(book)) {
						System.out.println("没有查询到此书的借阅记录！");
						break;
					}
					System.out.println("此书的借阅记录为：");

					System.out.println("书号：" + bookID + "  借出数量：" + t.bookMap.get(book));

					break;
				} else if (n == 6) {
					System.out.println("请输入借阅卡id");
					String borrowCardId = scanner.nextLine();
					CardModel card = new CardModel(borrowCardId);
					if (!t.cardList.contains(card)) {
						System.out.println("对不起，该借阅卡未开通");
					} else {

						t.RecordOfCard(borrowCardId);
					}
					break;
				} else if (n == 7) {
					System.out.println("借阅记录为：");
					t.bookListInfoOfOrderByCount();
					break;
				} else {
					System.out.println("请输入正确的操作！");
					break;
				}

			}
			// scanner.close();
		}
	}

	public void print() {
		System.out.println("-----------欢迎来到本图书信息管理系统-----------");
		System.out.println("请输入按键进行相应的操作！");
		System.out.println("1:进书");
		System.out.println("2:办理借阅卡");
		System.out.println("3:借书");
		System.out.println("4:还书");
		System.out.println("5:查询某书的借阅记录");
		System.out.println("6:查询某卡的借阅记录");
		System.out.println("7:按借阅次数，显示图书信息");
		System.out.println("0:输入0,退出本系统！");
		System.out.println("---------------------------------------------");

	}

	// 进书
	public void ProduceBook(int bookId, int bookCount) {

		BookModel book = new BookModel(bookId, bookCount);
		if(bookStockeMap.containsKey(book)) {
			bookStockeMap.put(book, bookStockeMap.get(book)+bookCount);
		}else {
			bookStockeMap.put(book, bookCount);
		}
		bookList.add(book);

	}

	// 办理借阅卡
	public void HandleCard(String cardId) {
		CardModel card = new CardModel(cardId);
		cardList.add(card);
		for (CardModel card2 : cardList) {
			if (card2.equals(card)) {
				System.out.println("借阅卡办理成功！您的卡号id为" + card2.getId());
			}
		}
	}

	// 借书
	public void BorrowBook(int bookId, String cardId) {
		BookModel book = new BookModel(bookId, cardId);
		CardModel card = new CardModel(cardId);
		BookBorrowModel bookBorrow = new BookBorrowModel(cardId, bookId);
		// 记录所有的借书情况
		
		//判断库存
		if(bookStockeMap.get(book)<=0) {
			System.out.println("库存不足");
			return;
		}
		
		//记录借书
		if (bookMap.containsKey(book)) {
			bookMap.put(book, bookMap.get(book) + 1);
		} else {
			bookMap.put(book, 1);

		}
		//扣减库存
		bookStockeMap.put(book, bookStockeMap.get(book)-1);

		// 根据不同的借阅卡记录借阅情况
		/**
		 * 定义一个cardHashMap，键存card，value存另一个map, 这个map的key保存bookBorrow,value存借阅的次数
		 * 关于bookBorrow,是新定义的一个实体类，包含借的书的id,以及借这本书的借阅卡的id 用于区分不同的借阅卡借阅同一本书的情况
		 * 
		 */
		if (cardHashMap.containsKey(card)) {
			if (temp.containsKey(bookBorrow)) {
				temp.put(bookBorrow, temp.get(bookBorrow) + 1);
			} else {
				temp.put(bookBorrow, 1);
			}

			cardHashMap.put(card, temp);
		} else {

			if (temp.containsKey(bookBorrow)) {
				temp.put(bookBorrow, temp.get(bookBorrow) + 1);
			} else {
				temp.put(bookBorrow, 1);
			}
			cardHashMap.put(card, temp);
		}
		System.out.println("借书成功!");
	}

	// 还书
	public void ReturnBook(int bookId, String cardId) {
		BookModel book = new BookModel(bookId);
		//修改借出记录
		bookMap.put(book, bookMap.get(book) - 1);
		//回补修改库存
		bookStockeMap.put(book, bookStockeMap.get(book)+1);
	}

	public void RecordOfBook(int bookId) {

	}

	// 根据借阅卡查询
	public void RecordOfCard(String cardId) {
		CardModel card = new CardModel(cardId);
		System.out.println("该借阅卡的借阅记录为：");
		for (CardModel card2 : cardHashMap.keySet()) {
			if (card2.equals(card)) {
				for (BookBorrowModel bookBorrow : cardHashMap.get(card).keySet()) {
					if (bookBorrow.getCardId().equals(card.getId())) {
						System.out.println("书号：" + bookBorrow.getBookId() + "  该卡累计借书次数 ："
								+ cardHashMap.get(card).get(bookBorrow));
					}
				}
			}
		}
	}

//根据借阅次数降序排序
	public void bookListInfoOfOrderByCount() {
		// System.out.println("借阅信息：");
		List<Map.Entry<BookModel, Integer>> list = new ArrayList<>(bookMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<BookModel, Integer>>() {
			@Override
			public int compare(Map.Entry<BookModel, Integer> o1, Map.Entry<BookModel, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (Map.Entry<BookModel, Integer> mEntry : list) {
			System.out.println(mEntry.getKey().getId() + "  累计借出次数：" + mEntry.getValue());
		}

	}

}
