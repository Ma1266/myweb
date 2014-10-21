<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>HTML5 Contact Form</title>

<style type="text/css">
.contact_form{border:1px solid #DDDDDD;padding:10px;width:760px;margin:40px auto 0 auto;}
</style>

<link rel="stylesheet" media="screen" href="style.css" >

</head>
<body>

<form class="contact_form" action="#" method="post" name="contact_form">
	<ul>
		<li>
			<h2>找回密码</h2>
			<span class="required_notification">* 表示必填项</span>
		</li>
		<li>
			<label for="name">姓名:</label>
			<input type="text"  placeholder="Javin" required />
		</li>
		<li>
			<label for="email">电子邮件:</label>
			<input type="email" name="email" placeholder="17sucai@example.com" required />
			<span class="form_hint">正确格式为：17sucai@something.com</span>
		</li>
		<li>
			<label for="website">网站:</label>
			<input type="url" name="website" placeholder="http://www.17sucai.com" required pattern="(http|https)://.+"/>
			<span class="form_hint">正确格式为：http://www.17sucai.com</span>
		</li>
		<li>
			<label for="message">留言:</label>
			<textarea name="message" cols="40" rows="6" placeholder="享受web前端开发和用户体验设计的乐趣" required ></textarea>
		</li>
		<li>
			<button class="submit" type="submit">提交</button>
		</li>
	</ul>
</form>

</body>
</html>