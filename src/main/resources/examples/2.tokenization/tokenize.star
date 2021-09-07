load("@vgs//vault", "vault")

def handle(secret):
   token = vault.redact(secret)
   return token

script_output = handle(script_input)