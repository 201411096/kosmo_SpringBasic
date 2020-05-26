<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>글 수정</title>
</head>
<body>
		<h1>글 수정</h1>		
		<hr>
		<form action="updateBoardContent.do" method="post"> <!--  enctype="multipart/form-data" -->
			<input type="hidden" name="seq" value="${board.seq}">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title" value="${board.title }"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">${board.writer}</td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"	value=" 글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
</body>
</html>