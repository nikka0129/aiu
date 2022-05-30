<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="header.html" %>

<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <title> ログイン画面</title>
  <link rel="icon" type="image/png" href="images/890.png">
  <link href="css/style2.css" rel="stylesheet" type="text/css">
</head>

<body>
  <div class="wrapper">
    <header class="header_top">
      <h1 id="sample">競馬<span id="sample">データベース</span></h1>

    </header>
    <div class="main_visual" id="aaa">


      </div>

      <html>

<head>

<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Sign in</title>
</head>

<body>
<div class="main">
  <p class="sign" align="center"> ログイン</p>
  <form class="form1" action="Login.action" method="post">
    <input class="un" type="text" name="login" align="center" placeholder="ユーザーネーム" required>
    <input class="pass" type="password" name="password" align="center" placeholder="パスワード" required>
    <button type="submit"  class="submit">ログイン
      </button>

    <p class="forgot" align="center"><a href="insert.jsp">新規登録</p>
</form>

  </div>




</body>

</html>
<%@include file="footer.html" %>
