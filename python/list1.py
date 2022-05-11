import random as r

a=[1,2,3,4,5]
print(a)

b = list(range(1,11))
print(b)

c = a+b
print(c)

print('a>>',a)
a.append(6)
print('a>>',a)

a.insert(3,7)
print('a>>',a)

#pop(): 맨 마지막 요소 삭제
#pop(x): x번째 요소 삭제 
a.pop()  
print(a)
a.pop(3)
print(a)

#remove(x): 리스트에서 첫 번째로 나오는 x를 삭제
a.remove(4)
print(a)

#index(x): 리스트에 x값이 있으면 x의 위치 값을 돌려준다
print(a.index(5))


a=list(range(1,11))
print(a)
print(sum(a)) #1~10까지의 합 출력
print(max(a)) #인자 값 중에서 최댓값 출력
print(min(a)) #인자 값 중에서 최솟값 출력
print(min(7,5,2))

print(a)
r.shuffle(a)
print(a)
a.sort() #sort(): 오름차순 정렬
print(a)
a.sort(reverse=True) #내림차순
print(a)

a.clear()
print(a)