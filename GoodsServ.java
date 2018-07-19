package com.hzyc.backMall.service;

import java.util.List;

import com.hzyc.backMall.po.Cart;
import com.hzyc.backMall.po.Commentary;
import com.hzyc.backMall.po.Goods;
import com.hzyc.backMall.po.GoodsType;
import com.hzyc.backMall.po.Orders;
import com.hzyc.backMall.po.Person;
import com.hzyc.backMall.po.StaTime;

public interface GoodsServ {
	
	public String isWhom(Person person);
	public List<GoodsType> selGTp();
	public GoodsType selTypeById(String id);
	public void updTypeById(GoodsType gt);
	public void addNewType(String type);
	public void delTypeById(String id);
	public void addGoods(Goods goods);
	public List<GoodsType> selGoods();
	public void updDelGoods(String id);
	public Goods selGoodsById(String id);
	public void updGoodsById(Goods goods);
	public Goods cSelGoods(String title);
	public void addUser(Person person);
	public Person judgeUser(Person person);
	public Goods gDetail(String id);
	public void addCart(Cart cart);
	public List<Person> selCart(String id);
	public void delCartById(String id);
	public Cart selCartById(String id);
	public void addOrderFromCart(Orders order);
	public void updGoodsNum(Goods goods);
	public String selGById0(String id);
	public List<Person> showOrder(String id);
	public void updSta(String id);
	public List<Person> orderHis(String id);
	public void addcomment(Commentary cty);
	public List<Person> selPl(String id);
	public List<Person> waitG(String id);
	public void updSta1(String id);
	public List<Orders> staNum(StaTime st);
	public List<Orders> staSum(StaTime st);
	public List<Person> seeCart();
	public List<Person> seeOrder();
	public String selAd();
	public String selAdSta();
	public void chaAdSta0(String id);
	public void chaAdSta1(String id);
	public List<Person> selUser();
}
