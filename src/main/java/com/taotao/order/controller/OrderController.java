package com.taotao.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.order.pojo.Order;
import com.taotao.order.service.OrderService;

/**
 * 订单Controller
 * <p>Title: OrderController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月16日上午10:46:50
 * @version 1.0
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	// 订单生成Demo数据（@RequestBody指定了请求数据为json格式）
	// 请求地址：http://172.17.203.121:8085/create
	/**
	 * form格式请求参数（@RequestBody指定了请求数据为json格式）
	 */
	/*
		{
		    "orderItems": [{
		        "itemId": 123456,
		        "orderId": 123456,
		        "num": "123456",
		        "title": 123456,
		        "price": 123456,
		        "totalFee": 123456,
		        "picPath": 123456
		    }],
		    "orderShipping": {
		        "orderId": 123456,
		        "receiverName": 123456,
		        "receiverPhone": 123456,
		        "receiverMobile": 123456,
		        "receiverState": 123456,
		        "receiverCity": 123456,
		        "receiverDistrict": 123456,
		        "receiverAddress": 123456
		    }
		}
	*/
	
	/**
	 * form格式请求参数（需要去掉@RequestBody）
	 */
	/*
	orderItems[0].itemId:123456
	orderItems[0].orderId:123456
	orderItems[0].num:123456
	orderItems[0].title:123456
	orderItems[0].price:123456
	orderItems[0].totalFee:123456
	orderItems[0].picPath:123456
	orderShipping.orderId:123456
	orderShipping.receiverName:123456
	orderShipping.receiverPhone:123456
	orderShipping.receiverMobile:123456
	orderShipping.receiverState:123456
	orderShipping.receiverCity:123456
	orderShipping.receiverDistrict:123456
	orderShipping.receiverAddress:123456
	*/
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	//public TaotaoResult createOrder(@RequestBody Order order) {	// @RequestBody注解用来指定请求数据格式为json格式
	public TaotaoResult createOrder(@RequestBody Order order) {	// @RequestBody注解用来指定请求数据格式为json格式
		try {
			TaotaoResult result = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
