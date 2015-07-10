package com.evojam.core.server

import javax.inject.Inject

import spray.routing._

import akka.actor.Actor

class RestServiceActor @Inject()(apiSet: Set[RouteComponent]) extends Actor with RestService {

  override def actorRefFactory = context

  override def receive = runRoute(standardRoutes getOrElse fallbackRoute)

  override protected[this] def apis = apiSet
}