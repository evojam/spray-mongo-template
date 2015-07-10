package com.evojam.core.akka

import scala.reflect._

import akka.actor._

import com.google.inject.Injector

object GuiceAkkaExtension extends ExtensionId[GuiceAkkaExtensionImpl] with ExtensionIdProvider {

  override def lookup() = GuiceAkkaExtension

  override def createExtension(system: ExtendedActorSystem) = new GuiceAkkaExtensionImpl
}

class GuiceAkkaExtensionImpl extends Extension {

  private var injector: Injector = _

  def initialize(injector: Injector) = this.injector = injector

  def props[A <: Actor : ClassTag] = {
    val producerClz = classTag[GuiceActorProducer[A]].runtimeClass
    val actorClz = classTag[A].runtimeClass
    Props(producerClz, injector, actorClz)
  }
}

