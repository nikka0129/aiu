<%@page contentType="text/html; charset=UTF-8" %>
こんにちは、${customer.login}さん。
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <title>目指せ万馬券</title>

  <link href="css/ress.css" rel="stylesheet" type="text/css">
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
  <div class="wrapper">
    <header class="header_top">
      <h1 id="sample">目指せ万馬券</h1>

    </header>
    <div class="main_visual" id="aaa">

      <a href="form2.html"><button class="btn2"> ログアウト</button></a>
      </div>



    <nav class="main_navigation">
      <ul>
        <li><a href="index.html">ホーム</a></li>
        <li><a href="umadata.html">競走馬　一覧</a></li>
        <li><a href="racedata.html">レースデータ</a></li>

      </ul>
    </nav>


    <article class="article_top">
      <section class="section_top3">

        <div>
        <h1 class="aiai">競走馬　検索</h1>



        <p>競走馬検索</p>
        <br>
        <p>検索キーワードを入力してください。</p>
<form id="form4" action="pkg1/search" method="post">
<input id="sbox4" type="text" name="keyword">
<input id="sbtn4" type="submit" value="検索">
</form>
      </div>
    </section>






    </article>

    <footer class="footer_top2">
      <div class="copyright">
        <small>&copy;UMADATA　2021</small>
      </div>
    </footer>

  </div>



</body>

</html>

