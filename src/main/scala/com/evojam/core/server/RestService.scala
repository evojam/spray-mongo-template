package com.evojam.core.server

import spray.routing._

trait RestService extends HttpService {

  protected[this] def apis: Set[RouteComponent]

  lazy val standardRoutes: Option[Route] = chainRoutes(apis.map(_.route).toList)

  lazy val fallbackRoute = path("/") {
    complete("No routes defined")
  }

  private def chainRoutes(routes: List[Route]) = routes match {
    case Nil => None
    case _ => chain(routes)
  }

  private def chain(routes: List[Route]) =
    routes.headOption.map(routes.foldLeft(_) { (next, chain) =>
      chain ~ next
    })

}