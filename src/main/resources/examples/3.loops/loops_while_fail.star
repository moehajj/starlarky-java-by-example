load("@vgs//vault", "vault")

def fail_while_infinite():
   i = 0
   while true:
      i += 1
   return i

def fail_while_conditional():
   i = 0
   while i < 5:
      i += 1
   return i

script_output = fail_while_infinite()
script_output = fail_while_conditional()