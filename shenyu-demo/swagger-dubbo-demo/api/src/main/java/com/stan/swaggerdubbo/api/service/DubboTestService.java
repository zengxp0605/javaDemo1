/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stan.swaggerdubbo.api.service;


import com.stan.swaggerdubbo.api.entity.DubboTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * DubboTestService.
 */
@Api(value = "TestApis", tags = "TestApis")
public interface DubboTestService {

    /**
     * find by id.
     * body：{"id":"1223"}
     *
     * @param id id
     * @return DubboTest dubbo test
     */
    @ApiOperation(value = "Id查找", notes = "Id查找")
    DubboTest findById(String id);

    /**
     * Find all dubbo test.
     *
     * @return the dubbo test
     */
    @ApiOperation(value = "全部列表", httpMethod = "GET")
    DubboTest findAll();

    /**
     * Insert dubbo test.
     * body :{"id":"122344","name":"xiaoyu"}
     *
     * @param dubboTest the dubbo test
     * @return the dubbo test
     */
    @ApiOperation(value = "插入数据")
    DubboTest insert(DubboTest dubboTest);

}
