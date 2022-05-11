a=[[0]*3 for i in range(3)]
print(a)
'''
아래와 같이 생각해라
0 0 0
0 0 0
0 0 0
'''
a[0][1] = 1   
print(a)
'''
[0, 1, 0]
[0, 0, 0]   == [[0, 1, 0], [0, 0, 0], [0, 0, 0]]
[0, 0, 0]
'''

for x in a:
  print(x)

for x in a:
  for y in x:
    print(y, end=' ')
  print()