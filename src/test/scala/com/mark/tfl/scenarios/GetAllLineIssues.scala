package com.mark.tfl.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetAllLineIssues {

  val getAllLineIssues: HttpRequestBuilder = http("get all line issues")
    .get("/issues")
    .check(status is 200)

  val getLineIssues: ScenarioBuilder = scenario("Get all line issues")
    .exec(getAllLineIssues)
}