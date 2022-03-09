package hello.core.order;

public interface OrderService {
    //주문 생성할 때 회원id, 상품명, 상품 가격을 파라미터로 넘겨야 함 --> 주문 서비스 역할(OrderService)에서 주문 결과를 return함
    //최종 order결과 반환한다
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
