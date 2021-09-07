
def fib(n):
   if n < 0:
      return 0
   elif n <= 1:
      return n
   else:
      return fib(n-1) + fib(n-2)

script_output = str(fib(int(script_input)))