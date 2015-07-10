package com.evojam.core.config

import com.google.inject.{Provides, Singleton}
import com.typesafe.config.{Config, ConfigFactory}
import net.codingwell.scalaguice.ScalaModule

object ConfigProvider extends ScalaModule {
  override def configure() = {}

  @Provides
  @Singleton
  def provideConfig(): Config = ConfigFactory.load()
}

