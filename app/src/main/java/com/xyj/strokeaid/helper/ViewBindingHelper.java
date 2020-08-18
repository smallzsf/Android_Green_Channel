//package com.xyj.strokeaid.helper;
//
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.Objects;
//
///**
// * ViewBindingHelper
// * description: TODO
// *
// * @author : Licy
// * @date : 2020/8/13
// * email ：licy3051@qq.com
// */
//public class ViewBindingHelper {
//
//    public static <Binding extends ViewBinding> Binding createViewBindingForActivity(
//            Class<?> clazz,
//            LayoutInflater layoutInflater) {
//        Binding binding = null;
//        Type type = clazz.getGenericSuperclass();
//        if (type instanceof ParameterizedType) {
//            try {
//                Class<Binding> bindingClass = (Class<Binding>) ((ParameterizedType) type).getActualTypeArguments()[0];
//                Method method = bindingClass.getMethod("inflate", LayoutInflater.class);
//                binding = (Binding) method.invoke(null, layoutInflater);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return Objects.requireNonNull(binding);
//    }
//
//    public static <Binding extends ViewBinding> Binding createViewBindingForFragment(
//            Class<?> clazz,
//            @NonNull LayoutInflater inflater,
//            @Nullable ViewGroup container) {
//        Binding binding = null;
//        Type type = clazz.getGenericSuperclass();
//        if (type instanceof ParameterizedType) {
//            try {
//                Class<Binding> bindingClass = (Class<Binding>) ((ParameterizedType) type).getActualTypeArguments()[0];
//                Method method = bindingClass.getMethod("inflate", LayoutInflater.class, Boolean.class);
//                binding = (Binding) method.invoke(null, container, false);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return Objects.requireNonNull(binding);
//    }
//}
//
//
//
//
//