package com.hzyc.backMall.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.hzyc.backMall.po.Cart;
import com.hzyc.backMall.po.Commentary;
import com.hzyc.backMall.po.Goods;
import com.hzyc.backMall.po.GoodsType;
import com.hzyc.backMall.po.Orders;
import com.hzyc.backMall.po.Person;
import com.hzyc.backMall.po.StaTime;
import com.hzyc.backMall.service.GoodsServ;

@Controller
public class AdmainController {
	@Autowired
	private GoodsServ gs;
	
	
	@RequestMapping("/isWhom.do")
	public ModelAndView isWhom (Person person){
		System.out.println(person);
		ModelAndView mav = new ModelAndView();
		if("管理员".equals(gs.isWhom(person))){
			mav.setViewName("administer.jsp");
		}
		return mav;
	}
	@RequestMapping("selGTp.do")
	public ModelAndView selGTp(){
		List<GoodsType> list = gs.selGTp();
		System.out.print("fjakl"+list.size());
		ModelAndView mav = new ModelAndView();

		mav.addObject("list", list);
		mav.setViewName("index.jsp");
		return mav;
	}
	@RequestMapping("selTypeById.do")
	public ModelAndView selTypeById (String id){
		GoodsType gt = gs.selTypeById(id);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("goodstype",gt);
		mav.setViewName("updType.jsp");
		return mav;
	}
	@RequestMapping("updTypeById.do")
	public String updTypeById (HttpServletRequest req){
		GoodsType gt = new GoodsType();
		gt.setId(req.getParameter("id"));
		gt.setType(req.getParameter("type"));
		gs.updTypeById(gt);
		return "selGTp.do";
	}
	@RequestMapping("addNewType.do")
	public ModelAndView addNewType(){
		System.out.println("hello");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addType.jsp");
		return mav;
	}
	
	@RequestMapping("addType.do")
	public String addType(HttpServletRequest req){
		gs.addNewType(req.getParameter("type"));
		return "selGTp.do";
	}
	@RequestMapping("/delTypeById.do")
	public String delTypeById(HttpServletRequest req){
		gs.delTypeById(req.getParameter("id"));
		return "selGTp.do";
	}
	@RequestMapping("/addGoods0.do")
	public String addGoods0(){
		return "addG.jsp";
	}
	@RequestMapping("/addGoods.do")
	public String addGodds(MultipartFile imgName, HttpServletRequest req)throws Exception{
		Goods gd = new Goods();
		gd.setBrand(req.getParameter("brand"));
		gd.setTitle(req.getParameter("title"));
		gd.setTypeId(req.getParameter("typeId"));
		gd.setDiscount(req.getParameter("discount"));
		gd.setPrice(req.getParameter("price"));
		gd.setStatus(req.getParameter("status"));
		gd.setDescription(req.getParameter("description"));
		gd.setNumber(req.getParameter("number"));
		String name = imgName.getOriginalFilename();
		String tomcatPath = req.getSession().getServletContext().getRealPath("/");
		String targetName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + name;
		File file = new File(tomcatPath+"image\\"+targetName);
		imgName.transferTo(file);
		gd.setImgname(targetName);
		gs.addGoods(gd);
		
		return "goodsInfo.jsp";
	}
	@RequestMapping("/transportType.do")
	public void transportType(HttpServletRequest req, HttpServletResponse resp){
		
		List<GoodsType> list = gs.selGTp();
		resp.setCharacterEncoding("utf-8");
		
		Gson gson = new Gson();
        String info = gson.toJson(list);
        
        try {
			PrintWriter out = resp.getWriter();
			out.print(info);
			out.flush();
			out.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	@RequestMapping("/selGoods.do")
	public ModelAndView selGoods(){
		List<GoodsType> list = gs.selGoods();
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("showGoods.jsp");
		return mav;
	}
	@RequestMapping("/updDelGoods.do")
	public String updDelGoods(String id){
		gs.updDelGoods(id);
		return "selGoods.do";
	}
	
	@RequestMapping("/selGoodsById.do")
	public ModelAndView selGoodsById(String id){
		Goods goods = gs.selGoodsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("goods", goods);
		mav.setViewName("updGoods.jsp");
		return mav;
	}
	@RequestMapping("/updGoodsById.do")
	public String updGoodsById(MultipartFile img1, HttpServletRequest req)throws Exception{
		Goods goods = new Goods();
		goods.setBrand(req.getParameter("brand"));
		goods.setDescription(req.getParameter("descrip"));
		goods.setDiscount(req.getParameter("discount"));
		goods.setId(req.getParameter("id"));
		goods.setNumber(req.getParameter("num"));
		goods.setPrice(req.getParameter("price"));
		goods.setStatus(req.getParameter("status"));
		goods.setTitle(req.getParameter("title"));
		goods.setTypeId(req.getParameter("typeId"));
		if(img1==null){
			goods.setImgname(req.getParameter("img"));
			gs.updGoodsById(goods);
			return "selGoods.do";
		}else{
			String name = img1.getOriginalFilename();
			String tomcatPath = req.getSession().getServletContext().getRealPath("/");
			String targetName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + name;
			File file = new File(tomcatPath+"image\\"+targetName);
			img1.transferTo(file);
			goods.setImgname(targetName);
			gs.updGoodsById(goods);
			return "selGoods.do";
		}
		
	}
	@RequestMapping("/showCus.do")
	public ModelAndView showCus(HttpServletRequest req){
		String item = req.getParameter("finds");
		ModelAndView mav = new ModelAndView();
		List<Goods> list = new ArrayList<Goods>();
		list.add(gs.cSelGoods(item));
		mav.addObject("list", list);
		mav.setViewName("showCusG.jsp");
		return mav;
	}
	@RequestMapping("/addUser.do")
	public String addUser(HttpServletRequest req){
		Person person = new Person();
		person.setUsername(req.getParameter("user"));
		person.setPassword(req.getParameter("password"));
		person.setEmail(req.getParameter("email"));
		gs.addUser(person);
		return "success.jsp";
	}
	@RequestMapping("/judgeUser.do")
	public String judgeUser(HttpServletRequest req){
		Person person = new Person();
		person.setUsername(req.getParameter("user"));
		person.setPassword(req.getParameter("password"));
		System.out.println("aaaa:"+req.getSession().getAttribute("imgTitle"));
		Person p1 = gs.judgeUser(person);
		if(p1==null){
			return "failLog.jsp";
		}else if("会员".equals(p1.getIdentity())){
			req.getSession().setAttribute("userId", p1.getId());
			req.getSession().setAttribute("username", p1.getUsername());
			return "homepage1.jsp";
		}else{
			return "failLog.jsp";
		}
		
	}
	//前台查询商品详情
	@RequestMapping("/gDetail.do")
	public ModelAndView gDetail(String id){
		Goods goods = gs.gDetail(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showDe.jsp");
		mav.addObject("goods", goods);
		return mav;
	}
	/*
	 * 
	 */
	@RequestMapping("/addCart.do")
	public String addCart(String goodsId, String goodsNum, HttpServletRequest req){
		Cart cart = new Cart();
		cart.setUserId(req.getSession().getAttribute("userId").toString());
		cart.setGoodsId(goodsId);
		cart.setNumber(goodsNum);
		Goods goods = gs.selGoodsById(goodsId);
		double discount = Double.parseDouble(goods.getDiscount());
		double price = Double.parseDouble(goods.getPrice());
		double money = discount * price * Double.parseDouble(goodsNum);
		cart.setMoney(""+money);
		gs.addCart(cart);
		return "homepage1.jsp";
	}
	//前台查询购物车
	@RequestMapping("/selCart.do")
	public ModelAndView selCart(HttpServletRequest req){
		List<Person> list = gs.selCart(req.getSession().getAttribute("userId").toString());
		/*System.out.println(list);*/
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("car.jsp");
		return mav;
	}
	@RequestMapping("/delCartById.do")
	public String delCartById(String id){
		gs.delCartById(id);
		return "selCart.do";
	}
	//从购物车确认订单
	@RequestMapping("/addOrderFromCart.do")
	public String addOrderFromCart(String id, HttpServletRequest req) throws UnsupportedEncodingException{
		Cart cart = gs.selCartById(id);
		Orders order = new Orders();
		req.setCharacterEncoding("utf-8");
		order.setAddress(req.getParameter("address"));
		order.setPhone(req.getParameter("phone"));
		System.out.println(req.getParameter("address"));
		System.out.println(req.getParameter("phone"));
		order.setUserId(cart.getUserId());
		order.setGoodsId(cart.getGoodsId());
		order.setMoney(cart.getMoney());
		order.setNumber(cart.getNumber());
		String buyNum = cart.getNumber();
		String priNum = gs.selGById0(cart.getGoodsId());
		int nowNum = Integer.parseInt(priNum)-Integer.parseInt(buyNum);
		System.out.println(nowNum);
		Goods goods = new Goods();
		goods.setId(cart.getGoodsId());
		goods.setNumber(""+nowNum);
		String createTime = new SimpleDateFormat("yyyy-MM-dd-HH:mm").format(new Date());
		order.setCreateTime(createTime);
		gs.addOrderFromCart(order);
		gs.updGoodsNum(goods);
		gs.delCartById(id);
		return "homepage1.jsp";
	}
	//前台查询订单
	@RequestMapping("/showOrder.do")
	public ModelAndView showOrder(HttpServletRequest req){
		List<Person> list = gs.showOrder(req.getSession().getAttribute("userId").toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("showOrder.jsp");
		return mav;
	}
	@RequestMapping("/updSta.do")
	public String updSta(String id, HttpServletRequest req){
		gs.updSta(id);
		
		return "homepage1.jsp";
	}
	@RequestMapping("/orderHis.do")
	public ModelAndView orderHis(HttpServletRequest req){
		List<Person> list = gs.orderHis(req.getSession().getAttribute("userId").toString());
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("orderHistory.jsp");
		return mav;
	}
	@RequestMapping("/inComment.do")
	public ModelAndView inComment(String id){
		Goods goods = gs.gDetail(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("goods", goods);
		mav.setViewName("comment.jsp");
		return mav;
	}
	@RequestMapping("/addcomment.do")
	public void addcomment(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setCharacterEncoding("utf-8");
		String comment = req.getParameter("pl");
		String goodsId = req.getParameter("goodsId");
		PrintWriter out = resp.getWriter();
		if(!"".equals(comment) && !"".equals(goodsId)){
			out.print("yes");
			Commentary cty = new Commentary();
			cty.setUserId(req.getSession().getAttribute("userId").toString());
			cty.setComment(comment);
			cty.setGoodsId(goodsId);
			gs.addcomment(cty);
		}else{
			out.print("no");
		}
		out.flush();
		out.close();
	}
	@RequestMapping("/selPl.do")
	public void selPl(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setCharacterEncoding("utf-8");
		String goodsId = req.getParameter("goodsId");
		List<Person> list = gs.selPl(goodsId);
		System.out.println(list);
		Gson gson = new Gson();
		String info = gson.toJson(list);
		PrintWriter out = resp.getWriter();
		out.print(info);
		out.flush();
		out.close();
	}
	@RequestMapping("/waitG.do")
	public ModelAndView waitG(HttpServletRequest req){
		List<Person> list = gs.waitG(req.getSession().getAttribute("userId").toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("waitG.jsp");
		return mav;
	}
	@RequestMapping("/updSta1.do")
	public String updSta1(String id){
		gs.updSta1(id);
		return "orderHis.do";
	}
	@RequestMapping("/activeH.do")
	public ModelAndView activeH(String id){
		Goods goods = gs.selGoodsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("goods", goods);
		mav.setViewName("showOneG.jsp");
		return mav;
	}
	
	//统计商品销量
	@RequestMapping("/staNum.do")
	public void staNum(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException{
		resp.setCharacterEncoding("utf-8");
		String time = req.getParameter("time");
		String time1 = req.getParameter("time1");
		PrintWriter out = resp.getWriter();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		  Date bt=sdf.parse(time); 
		  Date et=sdf.parse(time1); 
		  if (bt.before(et)){ 
			 StaTime st = new StaTime();
			 st.setTime1(time1);
			 st.setTime(time);
			 List<Orders> list = gs.staNum(st);
			 
			 List<Goods> list1 = new ArrayList<Goods>();
			 for(int i=0;i<list.size();i++){
				 for(int j=0;j<list.get(i).getGoodsList().size();j++){
					list1.add(list.get(i).getGoodsList().get(j));
				 }
			 }
			 Gson gson = new Gson();
			 String info = gson.toJson(list1);
			 out.print(info);
		  }else{ 
			  out.print("wrong");
		  } 
		  out.flush();
		  out.close();
	}
	@RequestMapping("/staSum.do")
	public void staSum(HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException{
		resp.setCharacterEncoding("utf-8");
		String time = req.getParameter("time");
		String time1 = req.getParameter("time1");
		PrintWriter out = resp.getWriter();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		  Date bt=sdf.parse(time); 
		  Date et=sdf.parse(time1); 
		  if (bt.before(et)){ 
			 StaTime st = new StaTime();
			 st.setTime1(time1);
			 st.setTime(time);
			 List<Orders> list = gs.staSum(st);
			 System.out.println(list);
			 List<Goods> list1 = new ArrayList<Goods>();
			 for(int i=0;i<list.size();i++){
				 for(int j=0;j<list.get(i).getGoodsList().size();j++){
					list1.add(list.get(i).getGoodsList().get(j));
				 }
			 }
			 Gson gson = new Gson();
			 String info = gson.toJson(list1);
			 out.print(info);
		  }else{ 
			  out.print("wrong");
		  } 
		  out.flush();
		  out.close();
	}
	//后台查看购物车
	@RequestMapping("/seeCart.do")
	public ModelAndView seeCart(){
		List<Person> list = gs.seeCart();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("seeCart.jsp");
		return mav;
	}
	//后台查看订单
	@RequestMapping("/seeOrder.do")
	public ModelAndView seeOrder(){
		List<Person> list = gs.seeOrder();
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("seeOrders.jsp");
		return mav;
	}
	//查询广告图片放list里传至主页
	@RequestMapping("/home.do")
	public ModelAndView selAd(HttpServletRequest req){
		String imgTitle = gs.selAd();
		req.getSession().setAttribute("imgTitle", imgTitle);
		ModelAndView mav = new ModelAndView();
		mav.addObject("imgTitle", imgTitle);
		mav.setViewName("homepage.jsp");
		return mav;
		
	}
	//修改广告图片状态
	@RequestMapping("/chanAd.do")
	public String chanAd(String id){
		String originalAd = gs.selAdSta(); 
		if("id".equals(originalAd)){
			return "home.do";
		}else{
			gs.chaAdSta0(originalAd);
			gs.chaAdSta1(id);
			return "home.do";
		}
	}
	//后台用户信息查询显示
	@RequestMapping("/showUser.do")
	public ModelAndView showUser(){
		List<Person> list = gs.selUser();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("showUser.jsp");
		return mav;
	}
}
