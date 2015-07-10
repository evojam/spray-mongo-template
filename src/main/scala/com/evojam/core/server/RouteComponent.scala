package com.evojam.core.server

import spray.routing._

trait RouteComponent {
  def route: Route
}
