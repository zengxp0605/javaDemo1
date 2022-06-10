
# 对springboot `is not eligible for getting processed`异常的处理

```log
2022-04-23 16:17:35.329 trationDelegate$BeanPostProcessorChecker : Bean 'dataCache' of type [com.stan.autoproxying.component.DataCache] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-04-23 16:17:35.330 trationDelegate$BeanPostProcessorChecker : Bean 'randomIntGenerator' of type [com.stan.autoproxying.component.RandomIntGenerator] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
```

**解决方案**
```java
    /**
     * 重点在这个地方注入时需要加上 @Lazy, 延迟注入对象属性
     */
    @Lazy
    @Autowired
    private RandomIntGenerator randomIntGenerator;

//    @Lazy
//    RandomIntProcessor(RandomIntGenerator randomIntGenerator) {
//        this.randomIntGenerator = randomIntGenerator;
//    }
```