# starlarky-java-by-example

## Java
Examples can be found in `src/main/resources/examples`

## Using py2Star
Lets look at how to use the [py2star](https://github.com/mahmoudimus/py2star) 
tool to convert from Python to Starlarky

#### Setup
```shell
git clone git@github.com:mahmoudimus/py2star.git
cd py2star
python -m venv venv
source venv/bin/activate
python setup.py install
cd src/py2star
```

#### Run
```shell
python ../../../src/main/resources/examples/5.json/json_py2star.py '{ "card_number": "4111111111111111" }'
python cli.py larkify ../../../src/main/resources/examples/5.json/json_py2star.py > ../../../src/main/resources/examples/5.json/json_py2star.star
```