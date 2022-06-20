package com.example.junitsystemconsolewrapper;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public final class OutputExtension implements AfterEachCallback, BeforeEachCallback, ParameterResolver {
    private Output output;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        output = new RecordingOutput();
        Class<?> aClass = context.getRequiredTestClass();

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            ReflectionUtils.makeAccessible(declaredField);
            if (declaredField.getType().isAssignableFrom(output.getClass())) {
                declaredField.set(context.getRequiredTestInstance(), output);
            }
        }
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        output.close();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        return type.isAssignableFrom(RecordingOutput.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return output;
    }
}
