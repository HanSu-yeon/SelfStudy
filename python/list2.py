a=[23,12,36,53,19]
print(a[:3]) #0-2번 index요소 출력
print(a[1:4])
print(len(a)) #문자열 길이

for i in range(len(a)):
  print(a[i], end=' ')
print()

for x in a:
  print(x, end=' ')
print()

#홀수만 출력
for x in a:
  if(x%2==1):
    print(x, end=' ')
print()

#enumerate : 인덱스 번호와 컬렉션의 원소를 tuple형태로 반환. for문과 함께 자주 사용
#ex) (0, 23) (1, 12) ... (4, 19)
for x in enumerate(a):
  print(x)
  
for x in enumerate(a):
  print(x[0],x[1])
print()


for index, value in enumerate(a):
  print(index, value)
print()

#all: 모두 True여야 True 리턴
if all(60>x for x in a):
  print("yes")
else:
  print("no")

#any: 하나라도 True인게 있으면 True리턴
if any(10>x for x in a):
  print("YES")
else:
  print("NO")