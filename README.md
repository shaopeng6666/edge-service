````
# 使用Apache Benchmark测试orders服务，没有fallback
ab -n 21 -c 1 -m POST http://localhost:9000/orders

# 使用Apache Benchmark测试catalog服务，有fallback
ab -n 21 -c 1 -m POST http://localhost:9000/books
````