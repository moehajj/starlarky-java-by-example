load("@stdlib//re", "re")

def extract_card(input):
   CREDIT_CARD_PATTERN = "(\\d{16})"
   return re.search(CREDIT_CARD_PATTERN, input).group()

def extract_date(input):
   DATE_PATTERN = "(\\d{2}\\/\\d{2}\\/\\d{4})"
   return re.search(DATE_PATTERN, input).group()


script_output = "Card Number: {}\nDate: {}".format(
                        extract_card(script_input),
                        extract_date(script_input)
                    )