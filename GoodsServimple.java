package com.hzyc.backMall.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.backMall.dao.GoodsMapper;
import com.hzyc.backMall.po.Cart;
import com.hzyc.backMall.po.Commentary;
import com.hzyc.backMall.po.Goods;
import com.hzyc.backMall.po.GoodsType;
import com.hzyc.backMall.po.Orders;
import com.hzyc.backMall.po.Person;
import com.hzyc.backMall.po.StaTime;
import com.hzyc.backMall.service.GoodsServ;

@Service
public class GoodsServimple implements GoodsServ{

	@Autowired
	private GoodsMapper gm;
	
	public String isWhom(Person person) {
		
		return gm.isWhom(person);
	}
	public List<GoodsType> selGTp() {
		
		return gm.selGTp();
	}
	public GoodsType selTypeById(String id) {
		
		return gm.selTypeById(id);
	}
	public void updTypeById(GoodsType gt) {
		gm.updTypeById(gt);
		
	}
	public void addNewType(String type) {
		gm.addNewType(type);
		
	}
	public void delTypeById(String id) {
		gm.delTypeById(id);
		
	}
	public void addGoods(Goods goods) {
		gm.addGoods(goods);
		
	}
	public List<GoodsType> selGoods() {
		
		return gm.selGoods();
	}
	public void updDelGoods(String id) {
		gm.updDelGoods(id);
		
	}
	public Goods selGoodsById(String id) {
		
		return gm.selGoodsById(id);
	}
	public void updGoodsById(Goods goods) {
		gm.updGoodsById(goods);
		
	}
	public Goods cSelGoods(String title) {
		
		return gm.cSelGoods(title);
	}
	public void addUser(Person person) {
		gm.addUser(person);
		
	}
	public Person judgeUser(Person person) {
		return gm.judgeUser(person);
	}
	public Goods gDetail(String id) {
		return gm.gDetail(id);
	}
	public void addCart(Cart cart) {
		gm.addCart(cart);
		
	}
	public List<Person> selCart(String id) {
		
		return gm.selCart(id);
	}
	public void delCartById(String id) {
		gm.delCartById(id);
		
	}
	public Cart selCartById(String id) {
		
		return gm.selCartById(id);
	}
	public void addOrderFromCart(Orders order) {
		gm.addOrderFromCart(order);
		
	}
	public void updGoodsNum(Goods goods) {
		gm.updGoodsNum(goods);
		
	}
	public String selGById0(String id) {
		
		return gm.selGById0(id);
	}
	public List<Person> showOrder(String id) {
		
		return gm.showOrder(id);
	}
	public void updSta(String id) {
		gm.updSta(id);
		
	}
	public List<Person> orderHis(String id) {
		
		return gm.orderHis(id);
	}
	public void addcomment(Commentary cty) {
		gm.addcomment(cty);
		
	}
	public List<Person> selPl(String id) {
		
		return gm.selPl(id);
	}
	public List<Person> waitG(String id) {
		
		return gm.waitG(id);
	}
	public void updSta1(String id) {
		gm.updSta1(id);
		
	}
	public List<Orders> staNum(StaTime st) {
	
		return gm.staNum(st);
	}
	public List<Orders> staSum(StaTime st) {
		
		return gm.staSum(st);
	}
	public List<Person> seeCart() {
		
		return gm.seeCart();
	}
	public List<Person> seeOrder() {
		
		return gm.seeOrder();
	}
	public String selAd() {
		
		return gm.selAd();
	}
	public String selAdSta() {
		
		return gm.selAdSta();
	}
	public void chaAdSta0(String id) {
		gm.chaAdSta0(id);
		
	}
	public void chaAdSta1(String id) {
		gm.chaAdSta1(id);
		
	}
	public List<Person> selUser() {
		
		return gm.selUser();
	}
	
	
	
}
