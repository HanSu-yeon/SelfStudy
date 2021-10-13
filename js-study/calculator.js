//예를들어 1,2를 눌렀을 때 12로 출력하기 위해 문자열로 처리
//계산기 실행했을 때 초깃값 세팅
let numOne = "";
let operator = "";
let numTwo = "";
const $operator = document.querySelector("#operator");
const $result = document.querySelector("#result");
//숫자 클릭시 리스너 함수(고차함수 사용x)
const onClickNumber = (event) => {
  if (!operator) {
    numOne += event.target.textContent;
    $result.value += event.target.textContent;
    return;
  }
  //이 아래로는 operator가 존재하는 경우에만 실행됨
  //numTwo가 빈 값이면 실행 (초깃값이 비어있으니 false => 조건을 !numTwo를 해 true로 바꿔주기)
  if (!numTwo) {
    $result.value = ""; //numTwo에 값을 저장하기 전에 화면을 비우는 작업
  }
  numTwo += event.target.textContent;
  $result.value += event.target.textContent;
};
//버튼마다 클릭이벤트 달아주기
//1.숫자 버튼
document.querySelector("#num-0").addEventListener("click", onClickNumber);
document.querySelector("#num-1").addEventListener("click", onClickNumber);
document.querySelector("#num-2").addEventListener("click", onClickNumber);
document.querySelector("#num-3").addEventListener("click", onClickNumber);
document.querySelector("#num-4").addEventListener("click", onClickNumber);
document.querySelector("#num-5").addEventListener("click", onClickNumber);
document.querySelector("#num-6").addEventListener("click", onClickNumber);
document.querySelector("#num-7").addEventListener("click", onClickNumber);
document.querySelector("#num-8").addEventListener("click", onClickNumber);
document.querySelector("#num-9").addEventListener("click", onClickNumber);
//연산자 처리 함수(고차함수 사용)
const onClickOperator = (op) => () => {
  //연속계산하기위해 if(numTwo)코드 추가
  if (numTwo) {
    /*numTwo가 존재할 때 연산자가 입력되면 기존 numOne과 numTwo를 입력받은 연산자에 맞게 계산한 후
    그 결괏값을 numOne에 저장한다. 그리고 numTwo는 초기화*/
    switch (operator) {
      case "+":
        $result.value = parseInt(numOne) + parseInt(numTwo);
        break;
      case "-":
        $result.value = numOne - numTwo;
        break;
      case "*":
        $result.value = numOne * numTwo;
        break;
      case "/":
        $result.value = numOne / numTwo;
        break;
      default:
        break;
    }

    numOne = $result.value;

    numTwo = "";
  }
  if (numOne) {
    operator = op;
    $operator.value = op;
  } else {
    alert("숫자를 먼저 입력하세요");
  }
};
//연산자 버튼

document.querySelector("#plus").addEventListener("click", onClickOperator("+"));
document
  .querySelector("#minus")
  .addEventListener("click", onClickOperator("-"));
document
  .querySelector("#divide")
  .addEventListener("click", onClickOperator("/"));
document
  .querySelector("#multiply")
  .addEventListener("click", onClickOperator("*"));
//계산버튼 클릭시
document.querySelector("#calculate").addEventListener("click", () => {
  if (numTwo) {
    switch (operator) {
      case "+":
        $result.value = parseInt(numOne) + parseInt(numTwo);
        break;
      case "-":
        $result.value = numOne - numTwo;
        break;
      case "*":
        $result.value = numOne * numTwo;
        break;
      case "/":
        $result.value = numOne / numTwo;
        break;
      default:
        break;
    }
    //연속 계산하기
    /*numTwo를 비워 두고 그 다음에 +와 3을 누르면 각각 operator와 numTwo에 저장한다
    =를 누르면 numOne에 저장된 결괏값과 3이 더해진다
    */
    $operator.value = "";
    numOne = $result.value; //결괏값을 numOne에 저장
    operator = ""; //연산자 비우기
    numTwo = ""; //numTwo 비워두기
  } else {
    alert("숫자를 먼저 입력하세요");
  }
});
//계산기 초기화 하기
document.querySelector("#clear").addEventListener("click", () => {
  numOne = "";
  operator = "";
  numTwo = "";
  $operator.value = "";
  $result.value = "";
});
