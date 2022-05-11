def add(a, b):
  c= a+b
  return c

#함수 add호출  
x= add(3, 2)
print(x)


def add2(a, b):
  c = a+b
  d = a-b
  return c, d

print(add2(3,2)) #tuple형태로 return한다

#---------소수면 True, 소수x면 False출력-------------
def isPrime(x):
  for i in range(2, x):
    if x%i==0: #약수면 False,즉 소수가 x
      return False
  return True

a=[12, 13, 7, 9, 19]
#소수만 출력
for y in a:
  if isPrime(y):
    print(y, end=' ')

