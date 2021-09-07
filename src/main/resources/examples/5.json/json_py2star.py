import json
import sys

def redact(secret):
   return "token"

def handle(input):
   input_json = json.loads(input)
   secret = input_json["card_number"]
   token = redact(secret)
   input_json["card_number"] = token
   return json.dumps(input_json)

script_input = sys.argv[1]
script_output = handle(script_input)

print(script_output)