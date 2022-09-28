<script>
function CheckPassword(confirm){
// 入力値取得
var input1 = password.value;
var input2 = confirm.value;
// パスワード比較
if(input1 != input2){
  confirm.setCustomValidity("入力値が一致しません。");
}else{
  confirm.setCustomValidity('');
}
}
</script>

<script type="text/javascript">
            function check(){
                if (mail_form.mail.value == ""){
                    //条件に一致する場合(メールアドレスが空の場合)
                    alert("メールアドレスを入力してください");    //エラーメッセージを出力
                    return false;    //送信ボタン本来の動作をキャンセルします
                }else{
                    //条件に一致しない場合(メールアドレスが入力されている場合)
                    return true;    //送信ボタン本来の動作を実行します
                }
            }
        </script>
