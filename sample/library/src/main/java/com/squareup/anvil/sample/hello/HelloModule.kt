package com.squareup.anvil.sample.hello

import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.sample.hello.bye.User
import com.squareup.anvil.sample.hello.bye.ciao.User
import com.squareup.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
object HelloModule {

  @Provides
  fun user(): User {
    return User()
  }
}
