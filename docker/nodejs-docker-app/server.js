const express = require('express'); //Express 모듈 불러오기
let os = require('os');

const PORT = 8080; //Express 서버를 위한 포트 설정
// const HOST='0.0.0.0'; //호스트 지정(생략)

//APP
const app = express(); //새로운 Express어플 생성
app.get('/', (req, res) => {
  res.send(`내가 만든 이미지다아아아ㅏ!!!! ${os.hostname}`);
});

app.listen(PORT);
console.log(`Running on http://localhost:${PORT}`);
