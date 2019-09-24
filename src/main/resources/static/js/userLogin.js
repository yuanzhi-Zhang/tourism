$(function() {
	// 生成从minNum到maxNum的随机数
	function randomNum(minNum, maxNum) {
		switch (arguments.length) {
		case 1:
			return parseInt(Math.random() * minNum + 1, 10);
			break;
		case 2:
			return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10);
			break;
		default:
			return 0;
			break;
		}
	}
	// 随机生成背景图片以及随机改变背景图中的你知道么的颜色
	var backPic = [ "images/321079.jpg", "images/323266.jpg",
			"images/321926.jpg", "images/322188.jpg", "images/319967.jpg",
			"images/322433.jpg", "images/323256.jpg", "images/323280.jpg",
			"images/322746.jpg" ];
	var colorList = [ "coral", "coral", "purple", "white", "white", "coral",
			"white", "blue", "coral" ];
	var backPic_i = randomNum(0, 8);
	$("#login_back").attr("src", backPic[backPic_i]);
	$(".hope-word").css('color', colorList[backPic_i]);
	$(".register_jump a").css('color', colorList[backPic_i]);

	// 账号密码框的焦点变化
	$("#accout").focus(function() {
		$("#accout").css('border', '1px coral solid');
	})

	// 获取图片的主色素
	// var canvas=document.getElementById('myCanvas');
	// var img=document.getElementById('login_back');
	//
	//
	// function getImageColor(canvas, img) {
	// canvas.width = img.width;
	// canvas.height = img.height;
	//
	// var context = canvas.getContext("2d");
	//
	// context.drawImage(img, 0, 0,canvas.width,canvas.height);
	//
	// // 获取像素数据
	// var data = context.getImageData(0, 0, img.width, img.height).data;
	// console.log(data)
	// var r=1,g=1,b=1;
	// // 取所有像素的平均值
	// for (var row = 0; row < img.height; row++) {
	// for (var col = 0; col < img.width; col++) {
	// // console.log(data[((img.width * row) + col) * 4])
	// if(row==0){
	// r += data[((img.width * row) + col)];
	// g += data[((img.width * row) + col) + 1];
	// b += data[((img.width * row) + col) + 2];
	// }else{
	// r += data[((img.width * row) + col) * 4];
	// g += data[((img.width * row) + col) * 4 + 1];
	// b += data[((img.width * row) + col) * 4 + 2];
	// }
	// }
	// }
	//
	// console.log(r,g,b)
	// // 求取平均值
	// r /= (img.width * img.height);
	// g /= (img.width * img.height);
	// b /= (img.width * img.height);
	//
	// // 将最终的值取整
	// r = Math.round(r);
	// g = Math.round(g);
	// b = Math.round(b);
	// console.log(r,g,b)
	// return "rgb(" + r + "," + g + "," + b + ")";
	// }
	// var OldColorValue = getImageColor(canvas,img);

	// 颜色取反方法
	// function ColorReverse(OldColorValue) {
	// var OldColorValue = '“0x”' + OldColorValue.replace(/#/g, "");
	// var str = '“000000”' + (0xFFFFFF - OldColorValue).toString(16);
	// return "#" + str.substring(str.length - 6, str.length);
	// }
	// console.log(ColorReverse(OldColorValue));

	// 访问后台数据库，登录信息是否正确
//	$(".btn_login").click(function() {
//		$.ajax({
//			type : 'POST',
//			url : "/tourism/User/login.do",
//			success : function(data) {
//				if (data) {
//					alert("You datas ： " + data);
//				} else {
//					alert("失败");
//				}
//			}
//		});
//	})

})