package com.moehajj.spring.boot.grpc.example;

import com.google.common.io.Resources;
import com.verygood.security.larkyapi.LarkyRuntime;
import org.apache.commons.lang3.tuple.Pair;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import javax.script.SimpleScriptContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StarlarkyRunner {

    private static final LarkyRuntime engine = new LarkyRuntime();
    private static final String INPUT_BINDING_KEY = "script_input";
    private static final String OUTPUT_BINDING_KEY = "script_output";

    public static void main(String[] args) throws IOException {
        Pair<String, String> inputPair = json();
        String codeSourceFile = inputPair.getLeft();
        String inputFile = inputPair.getRight();

        // Extract input
        String script = Resources.toString(Resources.getResource(codeSourceFile), StandardCharsets.UTF_8);
        String input = Resources.toString(Resources.getResource(inputFile), StandardCharsets.UTF_8);

        // Set script input context
        ScriptContext inputContext = new SimpleScriptContext();
        Bindings bindings = new SimpleBindings();
        bindings.put(INPUT_BINDING_KEY, input);
        inputContext.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        engine.setContext(inputContext);

        // Execute Script
        try {
            String output = (String) engine.executeScript(script, OUTPUT_BINDING_KEY, inputContext);
            System.out.println(output);
        } catch(ScriptException e) {
            e.printStackTrace();
        }
    }

    private static Pair<String,String> regex() {
        return Pair.of("examples/1.regex/regex.star", "examples/1.regex/regex_input.txt");
    }

    private static Pair<String,String> tokenization() {
        return Pair.of("examples/2.tokenization/tokenize.star", "examples/2.tokenization/tokenize_input.txt");
    }

    private static Pair<String,String> loops_fail() {
        return Pair.of("examples/3.loops/loops_while_fail.star", "");
    }

    private static Pair<String,String> loops_pass() {
        return Pair.of("examples/3.loops/loops_for_pass.star", "");
    }

    private static Pair<String,String> recursion() {
        return Pair.of("examples/4.recursion/recursion.star", "examples/4.recursion/recursion_input.txt");
    }

    private static Pair<String,String> json() {
        return Pair.of("examples/5.json/json_py2star.star", "examples/5.json/json_input.txt");
    }
}