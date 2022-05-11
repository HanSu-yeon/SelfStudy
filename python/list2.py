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

for x in enumerate(a):
  print(x)